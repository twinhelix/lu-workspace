%Question 1
%Lu Xin lx108




function [ ] = Question1( )
clear all; clc; close all;
% ------------------------ QUESTION 1.1 -------------------------- %
% A:6%, B:10%, C:12%
rateA = 0.06;
rateB = 0.1;
rateC = 0.12;

lambdas = 0:0.01:20; %0 <= lambda <= 20

f = 100;    % face value of 100
n = 10;     % 10 year maturity
m = 1;      % 1 coupon payment per year

pricesA = getCurve(f, rateA, n, m, lambdas);
pricesB = getCurve(f, rateB, n, m, lambdas);
pricesC = getCurve(f, rateC, n, m, lambdas);

plot(lambdas, pricesA, lambdas, pricesB, lambdas, pricesC)
% ---------------------------------------------------------------- %


% ------------------------ QUESTION 1.2 -------------------------- %
% A, B, C = 0.14
rate = 0.14;

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
periods = n * m;
coupon = f * c;
lambda = lambda/100;

if lambda == 0
    % No discounting, just sum all values
    price = f + periods * coupon;
else
    % Use price formula
    discount = 1/(1 + (lambda/m))^n;
    price = f * discount + coupon/lambda * (1 - 1 * discount);
end
end


