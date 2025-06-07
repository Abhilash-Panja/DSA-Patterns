# 🧠 Matrix Chain Multiplication (MCM) Pattern

---

## 📌 When to Use?

Use the **MCM Pattern** when the problem:

- Involves **partitioning** the input (usually an array or string) optimally.
- Asks for **minimum or maximum cost/value** after partitioning.
- Requires operations on **subarrays** or **substructures** recursively.
- Typical in problems like:
  - Matrix Chain Multiplication
  - Palindrome Partitioning
  - Boolean Parenthesization
  - Burst Balloons
  - Evaluate Expression to True
  - Optimal BST

---

## 🔁 Recursive Skeleton (Template)

```java
int rec(int i, int j) {
    // Step 1: Place i and j in valid positions

    // Step 2: Base case
    if (i > j) return 0;  // Nothing to partition

    int ans = Integer.MAX_VALUE; // or MIN_VALUE based on max/min problem

    // Step 3: Partition the input at different k
    for (int k = i; k < j; k++) {
        // Recursive calls on left and right partitions
        int left = rec(i, k);
        int right = rec(k + 1, j);

        // Cost/Operation of combining results
        int cost = left + right + currOperationCost(i, k, j);

        ans = Math.min(ans, cost); // or max based on the problem
    }

    return ans;
}
```

---

## 🧩 Key Revision Notes

| Step      | Purpose                                                                 |
| --------- | ----------------------------------------------------------------------- |
| `i, j`    | Represent the range (subarray/subproblem) currently being solved.       |
| Base Case | Usually: `if(i > j) return 0;` (Nothing to partition)                   |
| Loop      | `for (int k = i; k < j; k++)` — Try all possible partitions.            |
| Recursive | Call on left: `rec(i, k)` and right: `rec(k + 1, j)`                    |
| Cost Func | Compute operation-specific cost between the partitions.                 |
| Combine   | Use `Math.min()` or `Math.max()` based on whether you want min/max cost |

---

## 🧮 Common Modifications

- **Memoization:** Use a `dp[i][j]` table to avoid recomputation.
- **Tabulation:** Bottom-up implementation for optimization.
- **CurrOperationCost:** Change this logic depending on the problem (e.g., for matrix chain, it’s `arr[i-1] * arr[k] * arr[j]`).

---
