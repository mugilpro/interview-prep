


Node        Parent
1               2
3               2
6               8
9               8
2               5
8               5
5               NULL

                    5

             2               8

        1         3      6         9

Select distinct c.n,
        case when c.P is null then 'Root'
             when b1.N is null then 'Leaf'
             else 'Inner' end
from BST c
left join BST b1
on c.N = b1.P
order by c.n;


1 Leaf
2 Inner
3 Leaf
5 Root
6 Leaf
8 Inner
9 Leaf
