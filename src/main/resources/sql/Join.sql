Students
ID          NAME
1           Samantha
2           Julia
3           Britney
4           Kristeen
5           Dyana
6           Jenny
7           Christene
8           Meera
9           Priya
10          Priyanka
11          Paige
12          Jane
13          Belvet
14          Scarlet
15          Salma
16          Amanda
17          Maria
18          Stuart
19          Aamina
20          Amina

Friends
ID          FRIEND_ID
1           14
2           15
3           18
4           19
5           20
6           5
7           6
8           7
9           8
10          1
11          2
12          3
13          4
14          9
15          10
16          11
17          12
18          13
19          16
20          17

Packages
ID          SALARY
1           15.5
2           15.6
3           16.7
4           18.8
5           31.5
6           45
7           47
8           46
9           39
10          11.1
11          12.1
12          13.1
13          14.1
14          15.1
15          17.1
16          21.1
17          31.1
18          13.15
19          33.33
20          22.16

select s.name from Students s, Friends f, Packages fp, Packages op
where s.id = f.id and
f.friend_id = fp.id and
s.id = op.id and
fp.salary > op.salary
order by fp.salary;

Stuart
Priyanka
Paige
Jane
Julia
Belvet
Amina
Kristeen
Scarlet
Priya
Meera
