%Question 1 - Price-Yield Curves
%Lu Xin lx108

function [ ] = Question1( )
clear all; clc; close all;
% ------------------------ QUESTION 1.a -------------------------- %
% A:6%, B:10%, C:12%
rateA = 0.06;
rateB = 0.1;
rateC = 0.12;

lambdas = 0:1:20; %0 <= lambda <= 20

f = 100;    % face value of 100
years = 10;     % 10 year maturity
m = 1;      % 1 coupon payment per year
n = years * m;

pricesA = getCurve(f, rateA, n, m, lambdas);
pricesB = getCurve(f, rateB, n, m, lambdas);
pricesC = getCurve(f, rateC, n, m, lambdas);

subplot(1,2,1);
plot(lambdas, pricesA, lambdas, pricesB, lambdas, pricesC);
legend('Bond A - 6%', 'Bond B - 10%', 'Bond C - 12%');
xlabel('YTM');
ylabel('Price');
title('Price-Yield Curve and Coupon Rates (10 Year)');
% ---------------------------------------------------------------- %


% ------------------------ QUESTION 1.b -------------------------- %
% A, B, C = 0.14
rate = 0.14;
m = 2;
dateNow = datenum(2012, 3, 1);
dateA = datenum(2012, 9, 1);
dateB = datenum(2013, 3, 1);
dateC = datenum(2014, 9, 1);

% work out the n for each bond
difference = datevec(dateA) - datevec(dateNow);
nA = (12 * difference(1) + difference(2))/6;
difference = datevec(dateB) - datevec(dateNow);
nB = (12 * difference(1) + difference(2))/6;
difference = datevec(dateC) - datevec(dateNow);
nC = (12 * difference(1) + difference(2))/6;

pricesA = getCurve(f, rate, nA, m, lambdas);
pricesB = getCurve(f, rate, nB, m, lambdas);
pricesC = getCurve(f, rate, nC, m, lambdas);

tab = [lambdas; pricesA; pricesB; pricesC]


subplot(1,2,2);
plot(lambdas, pricesA, lambdas, pricesB, lambdas, pricesC);
legend('Bond A - Sep 2012', 'Bond B - Mar 2013', 'Bond C - Sep 2014');
xlabel('YTM');
ylabel('Price');
title('Price-Yield Curve and Maturity Date (14%)');

% ---------------------------------------------------------------- %
end

% Price Curve function for a given bond
function [prices] = getCurve(f, rate, n, m, lambdas)
i = 1;
prices = zeros(size(lambdas));
for elm = lambdas
    prices(i) = getPrice(f, rate, n, m, elm);
    i = i+1;
end
end

% Price Function - given in notes
function [price] = getPrice(f, c, n, m, lambda)

coupon = f * c;
lambda = lambda/100;

if lambda == 0
    % No discounting, just sum all values
    price = f + n * (coupon/m);
else
    % Use price formula
    discount = 1/(1 + (lambda/m))^n;
    price = f * discount + coupon/lambda * (1 - 1 * discount);
end
end
