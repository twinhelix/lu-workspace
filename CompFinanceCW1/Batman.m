% Grey axes

axes('Xlim'  ,[-7 7]    , 'Xtick' ,-7:7,...
     'Ylim'  ,[-5 5]    , 'Ytick' ,-5:5,...
     'YtickL',''        , 'XtickL',''  ,...
     'Ygrid' ,'on'      , 'Xgrid' ,'on',...
     'Xcolor',[.8 .8 .8], 'Ycolor',[.8 .8 .8]);
hold on
% Outer wings

f1 = '(x/7)^2 * sqrt(abs(abs(x)-3)/(abs(x)-3)) + (y/3)^2 * sqrt(abs(y + 3/7*sqrt(33))/(y + 3/7*sqrt(33))) - 1';
ezplot(f1,[-8 8 -3*sqrt(33)/7 6-4*sqrt(33)/7]);
% Bottom

f2 = 'abs(x/2)-(3*sqrt(33)-7) * x^2/112 - 3 + sqrt(1-(abs(abs(x)-2)-1)^2) - y';
ezplot(f2,[-4 4]);
% Outer ears

f3 = '9 * sqrt(abs((1-abs(x))*(abs(x)-0.75)) / ((1-abs(x))*(abs(x)-0.75))) - 8*abs(x) - y';
ezplot(f3,[-1    -0.75 -5 5]);
ezplot(f3,[ 0.75  1    -5 5]);
% Inner ears

f4 = '3*abs(x) + 0.75*sqrt(abs((0.75-abs(x))*(abs(x)-.5)) / ((.75-abs(x))*(abs(x)-.5))) - y';
ezplot(f4,[-0.75 0.75 2.25 5]);
% Connect inner ears (flat line)

f5 = '2.25*sqrt(abs(((0.5-x)*(0.5+x))/((0.5-x)*(0.5+x)))) - y';
ezplot(f5,[-0.5 0.5 -5 5]);
% Inner wings

f6 = '6*sqrt(10)/7 + (1.5-0.5*abs(x)) * sqrt(abs(abs(x)-1) / (abs(x)-1)) - 6*sqrt(10)/14 * sqrt(4-(abs(x)-1)^2) - y';
ezplot(f6,[-3 -1 -5 5]);
ezplot(f6,[ 1  3 -5 5]);
% Change line color and width

set(get(gca,'children'),'Color','b','Linew',2)
% Title and labels

title('Batman'); xlabel(''); ylabel('')
% Superimpose black axes with xy-ticklabels

xlbl(1:15,1:2) = ' '; xlbl([1,8,15],:) = ['-7';' 0';' 7'];
ylbl(1:11,1:2) = ' '; ylbl([1,6,11],:) = ['-5';' 0';' 5'];
axes('Xlim'  ,[-7 7], 'Xtick' ,-7:7,...
     'Ylim'  ,[-5 5], 'Ytick' ,-5:5,...
     'YtickL',ylbl  , 'XtickL',xlbl,...
     'Box'   ,'on'  , 'Color' ,'none');