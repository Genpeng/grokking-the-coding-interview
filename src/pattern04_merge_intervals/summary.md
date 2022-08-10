# 区间合并题型总结

## 区间操作

假设有两个区间 A（`A = [la, ra]`）和 B（`B = [lb, rb]`），

判断是否有交集：
```
(la >= lb && la <= rb) || (lb >= la && lb <= ra)
```

取交集：
```
l = Math.max(la, lb)
r = Math.min(ra, rb)
```

取并集：
``` 
l = Math.min(la, lb)
r = Math.max(ra, rb)
```