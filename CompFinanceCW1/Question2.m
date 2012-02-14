%Question 2 - Portfolio Optimization with a Twist
%Lu Xin lx108

function [ ] = Question2( )
clear all; clc; close all;
% ---------------------------- SETUP ---------------------------- %
mu = [0.006 0.01 0.014 0.018 0.022];

sigma = [0.085 0.08 0.095 0.09 0.1];

corr = zeros(5,5);
for i = 1:5
    for j = 1:5
        if i == j
            corr(i,j) = 1;
        else
            corr(i,j) = 0.3;
        end
    end
end
% Short-Selling allowed
% Returns corresponding to different months are mutually independent
% ---------------------------------------------------------------- %
% ------------------------ QUESTION 2.a -------------------------- %
%{
Formulate the usual Markowitz model for an investment horizon of one month
as well as two related optimization problems to find the portfolios with
the highest expected return and the smallest variance, respectively.
Please state all of these problems mathematically.
%}

horizon = 1;
for i = 1:5
    for j = i:5
        if i ~= j
            %optimize
            [i, j]
            [ret, sig] = markowitz(mu(i), mu(j), sigma(i), sigma(j), corr(i,j))
        end
    end
end

% ---------------------------------------------------------------- %
end

function [ret, sigma] = markowitz(mu1, mu2, sigma1, sigma2, corr12)
[w1, w2] = lagrange(sigma1, sigma2, corr12)
ret = w1*mu1 + w2*mu2;
sigma = sqrt((w1*sigma1)^2 + (w2*sigma2)^2 + 2*w1*w2*corr12);
end

function [w1,w2] = lagrange(sigma1, sigma2, corr12)
w1 = (sigma2^2 - corr12)/(sigma1^2 - 2 * corr12 + sigma2^2);
w2 = 1 - w1;
end