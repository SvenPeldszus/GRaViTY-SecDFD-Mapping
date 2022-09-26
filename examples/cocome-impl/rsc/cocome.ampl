option solver cplex.exe;
model cocome.mod;
data cocome.dat;
solve;
display shipping_amount;
