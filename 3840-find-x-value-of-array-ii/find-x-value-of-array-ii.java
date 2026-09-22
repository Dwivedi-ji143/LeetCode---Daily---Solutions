class Solution {
    int n, k;
    Node[] tree;

    class Node {
        int[] rem = new int[k];
        int prod = 1;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        tree = new Node[4 * n];

        for (int i = 0; i < n; i++)
            nums[i] %= k;

        for (int[] q : queries)
            q[1] %= k;

        build(nums, 0, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];

            update(0, 0, n - 1, q[0], q[1]);
            ans[i] = query(0, 0, n - 1, q[2], n - 1).rem[q[3]];
        }

        return ans;
    }

    void build(int[] a, int p, int l, int r) {
        tree[p] = new Node();

        if (l == r) {
            tree[p].rem[a[l]] = 1;
            tree[p].prod = a[l];
            return;
        }

        int m = (l + r) / 2;

        build(a, 2 * p + 1, l, m);
        build(a, 2 * p + 2, m + 1, r);

        tree[p] = merge(tree[2 * p + 1], tree[2 * p + 2]);
    }

    void update(int p, int l, int r, int idx, int val) {
        if (l == r) {
            tree[p] = new Node();
            tree[p].rem[val] = 1;
            tree[p].prod = val;
            return;
        }

        int m = (l + r) / 2;

        if (idx <= m)
            update(2 * p + 1, l, m, idx, val);
        else
            update(2 * p + 2, m + 1, r, idx, val);

        tree[p] = merge(tree[2 * p + 1], tree[2 * p + 2]);
    }

    Node query(int p, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return new Node();

        if (ql <= l && r <= qr)
            return tree[p];

        int m = (l + r) / 2;

        return merge(
            query(2 * p + 1, l, m, ql, qr),
            query(2 * p + 2, m + 1, r, ql, qr)
        );
    }

    Node merge(Node a, Node b) {
        Node res = new Node();

        res.prod = (a.prod * b.prod) % k;

        for (int i = 0; i < k; i++)
            res.rem[i] = a.rem[i];

        for (int i = 0; i < k; i++)
            res.rem[(i * a.prod) % k] += b.rem[i];

        return res;
    }
}