%Question 1 - Price-Yield Curves
%Lu Xin lx108

function [ ] = Question2( )
clear all; clc; close all;


% ---------------------------- SETUP ---------------------------- %
mu1 = 0.006;
mu2 = 0.01;
mu3 = 0.014;
mu4 = 0.018;
mu5 = 0.022;

signma1 = 0.085;
signma2 = 0.08;
signma3 = 0.095;
signma4 = 0.09;
signma5 = 0.1;

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















% ---------------------------------------------------------------- %

end