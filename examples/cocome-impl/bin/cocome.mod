set STORE ordered;
set PRODUCT ordered;

param dist {STORE} >= 0;
param amount {PRODUCT} >= -0;
param stock {PRODUCT,STORE} >= 0;

var shipping_amount {i in PRODUCT, j in STORE} integer >= 0, <= stock[i,j];
var x {j in STORE} integer >= 0, <= 1;

minimize Total_Dist:  sum {j in STORE} dist[j] * x[j];

subject to Sat {i in PRODUCT}:
   amount[i] = sum {j in STORE} shipping_amount[i,j];
   
subject to Route {j in STORE}:
   sum{i in PRODUCT} shipping_amount[i,j] <= x[j]*40000;
   