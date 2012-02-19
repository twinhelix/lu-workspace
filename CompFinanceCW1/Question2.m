%Question 2 - Portfolio Optimization with a Twist
%Lu Xin lx108

function [ ] = Question2( )
clear all; clc; close all;
% ---------------------------- SETUP ---------------------------- %
% Monthly Returns:
mu = [0.006 0.01 0.014 0.018 0.022];
% Correlation Matrix:
sig = [0.085 0.08 0.095 0.09 0.1];

corr = ones(5)*0.3 + eye(5)*0.7;
covMatrix = corr2cov(sig, corr);

% Short-Selling not allowed
% Returns corresponding to different months are mutually independent
% ---------------------------------------------------------------- %

% Call part 2a
e = ones (1,5);
b = 1;

f = zeros (1,5);
[weights, pvar] = markowitz(covMatrix, f, e, b)
rmin = mu * weights

f = -mu;
H = zeros(5);
[weights, ret] = markowitz(H, f, e, b)
rmax = -ret

% Call part 2b
optimization(rmin, rmax)

% ---------------------------------------------------------------- %




% 2.a: Horizon of 1, markowitz model
    function [weights, result] = markowitz(H, f, A, b)
        
        lb = zeros(1, 5);
        opts = optimset('Algorithm','active-set','Display','off');
        
        [weights,result,exitflag,output,lambda] = ...
            quadprog(H,f,[],[],A,b,lb,[],[],opts);
    end
% ---------------------------------------------------------------- %

% 2.b Plot efficient frontier
    function [] = optimization(rmin, rmax)
        effFront = ones(10,2);
        
        f = zeros (1,5);
        A = [mu; ones(1,5)];
        
        for i=0:9
            rp = rmin + i * ((rmax - rmin)/9);
            b = [rp 1];
           
            [weights, result]  = markowitz(covMatrix, f, A, b);
            effFront(i+1,1) = result;
            effFront(i+1,2) = rp;
        end

       plot(effFront(:,1),effFront(:,2))
    end
% ---------------------------------------------------------------- %


end
