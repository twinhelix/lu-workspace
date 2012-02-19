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
[weights, pvar] = markowitz(covMatrix, f, e, b);
rmin = mu * weights;

f = -mu;
H = zeros(5);
[weights, ret] = markowitz(H, f, e, b);
rmax = -ret;

% Call part 2b
subplot(2,2,1);

[trueFrontier, trueWeights] = optimization(covMatrix, mu, rmin, rmax);
title('True Efficient Frontier');

% Call part 2c
[estiFrontier, estWeights] = randomReturns();

% Part 2d
actualReturns = estWeights * mu';
actualVariances = diag(estWeights * covMatrix * estWeights');
subplot(2,2,3);
plot(actualVariances, actualReturns);
xlabel('Variance');
ylabel('Expected Return of Portfolio');
title('Actual Efficient Frontier');

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
    function [effFrontier, effWeights] = optimization(H, mu, rmin, rmax)
        effFrontier = ones(10,2);
        effWeights = ones (10,5);
        f = zeros (1,5);
        A = [mu; ones(1,5)];
        
        for i=0:9
            rp = rmin + i * ((rmax - rmin)/9);
            b = [rp 1];
            
            [weights, result]  = markowitz(H, f, A, b);
            effFrontier(i+1, :) = [result rp];
            effWeights(i+1, :) = weights;
        end
        
        plot(effFrontier(:,1),effFrontier(:,2))
        %legend('Bond A', 'Bond B', 'Bond C');
        xlabel('Variance');
        ylabel('Expected Return of Portfolio');
        
        
    end
% ---------------------------------------------------------------- %

% 2.c
    function [estiFrontier, estWeights] = randomReturns()
        randomReturns = rand(24,5)
        mu1 = mean(randomReturns)
        sig = var(randomReturns)
        covMatrix = cov(randomReturns)
        
        % Get min variance portfolio
        e = ones (1,5);
        b = 1;
        
        f = zeros (1,5);
        [weights, pvar] = markowitz(covMatrix, f, e, b);
        rmin = mu1 * weights;
        
        % Get max return portfolio
        f = -mu1;
        H = zeros(5);
        [weights, ret] = markowitz(H, f, e, b);
        rmax = -ret;
        
        %
        subplot(2,2,2)
        [estiFrontier, estWeights] = optimization(covMatrix, mu1, rmin, rmax)
        title('Estimated Efficient Frontier');
        
    end
% ---------------------------------------------------------------- %

end
