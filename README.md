# 🧑🏽‍💻 DSA — LeetCode Solutions

A collection of my LeetCode solutions in Java, organized by pattern.

---

## 📂 Structure

```
dsa/
  arrays-hashing/
  two-pointers/
  sliding-window/
  stack/
  binary-search/
  trees/
  graphs/
  ... 
```

---

## 🤴🏽 Each solution includes

- Time & Space complexity
- Pattern used
- Clean, readable Java code

---

## 🚀 Progress

| Pattern | Problems solved | Status        |
|---|-----------------|---------------|
| Arrays & Hashing | 9               | 🔥 Done       |
| Two Pointers | 4               | 🔥 Done       |
| Sliding Window | 4               | 🔥 Done       |
| Stack | 5               | 🔥 Done  |
| Binary Search | 5               | ✨ In progress    |
| Trees | 0               | ⏳ Upcoming    |
| Graphs | 0               | ⏳ Upcoming    |

---

## 📝 Problems

### Arrays & Hashing
| # | Problem | Difficulty | Pattern |
|---|---|---|---|
| 1 | Two Sum | Easy | HashMap |
| 217 | Contains Duplicate | Easy | HashSet |
| 242 | Valid Anagram | Easy | Frequency array |
| 49 | Group Anagrams | Medium | HashMap — canonical key |
| 347 | Top K Frequent Elements | Medium | HashMap + PriorityQueue |
| 271 | Encode and Decode Strings | Medium | Length-prefix protocol |
| 238 | Product of Array Except Self | Medium | Prefix / Suffix |
| 36 | Valid Sudoku | Medium | Set + Map |
| 128 | Longest Consecutive Sequence | Medium | HashSet |

### Two Pointers
| # | Problem | Difficulty | Pattern |
|---|---|---|---|
| 125 | Valid Palindrome | Easy | Two Pointers |
| 167 | Two Sum II | Medium | Two Pointers |
| 15 | 3Sum | Medium | Two Pointers + outer loop |
| 11 | Container With Most Water | Medium | Two Pointers |

### Sliding Window
| #   | Problem                                        | Difficulty | Pattern                      |
|-----|------------------------------------------------|--------|------------------------------|
| 121 | Best Time to Buy and Sell Stock                | Easy   | Min sliding                  |
| 3   | Longest Substring Without Repeating Characters | Medium | Sliding Window               |
| 424 | Longest Repeating Character Replacement        | Medium | Sliding Window x Max freq    |
| 567 | Permutation in String                          | Medium | Sliding Window x letter freq |

### Stack
| #   | Problem                          | Difficulty | Pattern                                                      |
|-----|----------------------------------|------------|--------------------------------------------------------------|
| 20  | Valid Parentheses                | Easy       | Stack - Macthing pairs                                       |
| 155 | Min Stack                        | Medium     | Stack - Min Stack                                            |
| 150 | Evaluate Reverse Polish Notation | Medium     | Stack - push operands, pop two on operator, push result back |
| 739 | Daily Temperatures               | Medium     | Stack - Monotonic Stack - decreasing                         |
| 853 | Car Fleet                        | Medium     | Stack - Monotonic Stack - increasing                         |

### Binary Search
| #   | Problem             | Difficulty | Pattern |
|-----|---------------------|------------|-|
| 704 | Binary search       | Easy       | left/right pointers, Mid comparison |
| 74  | Search a 2D Matrix  | Medium     | treat 2D matrix as flattened 1D array |
| 875 | Koko Eating Bananas | Medium     | Binary search on answer space - monotonic predicate |
| 153 | Find Minimum in Rotated Sorted Array | Medium     | pivot detection, compare mid to right anchor |
| 33  | Search in Rotated Sorted Array | Medium     | identify sorted half, then decide range|
