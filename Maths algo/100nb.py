from random import *

def remp100nb():
    tab=[]
    a=0
    b=0
    c=0
    d=0
    e=0
    f=0
    g=0
    h=0
    j=0
    k=0
    
    for i in range (100):
        tab.append(randint(1,10))
    
        if tab[i] == 1:
            a=a+1
        elif tab[i] == 2:
            b=b+1
        elif tab[i] == 3:
            c=c+1
        elif tab[i] == 4:
            d=d+1
        elif tab[i] == 5:
            e=e+1
        elif tab[i] == 6:
            f=f+1
        elif tab[i] == 7:
            g=g+1
        elif tab[i] == 8:
            h=h+1
        elif tab[i] == 9:
            j=j+1
        elif tab[i] == 10:
            k=k+1
        else:
            print("erreur")        
    print (tab,"\n")
    print ("il y a ",a,": 1")
    print ("il y a ",b,": 2")
    print ("il y a ",c,": 3")
    print ("il y a ",d,": 4")
    print ("il y a ",e,": 5")
    print ("il y a ",f,": 6")
    print ("il y a ",g,": 7")
    print ("il y a ",h,": 8")
    print ("il y a ",j,": 9")
    print ("il y a ",k,": 10")
   
    a=a/100
    b=b/100
    c=c/100
    d=d/100
    e=e/100
    f=f/100
    g=g/100
    h=h/100
    j=j/100
    k=k/100
    print("\n")
    print("La fréquence d'apparition de 1 est :",a)
    print("La fréquence d'apparition de 2 est :",b)
    print("La fréquence d'apparition de 3 est :",c)
    print("La fréquence d'apparition de 4 est :",d)
    print("La fréquence d'apparition de 5 est :",e)
    print("La fréquence d'apparition de 6 est :",f)
    print("La fréquence d'apparition de 7 est :",g)
    print("La fréquence d'apparition de 8 est :",h)
    print("La fréquence d'apparition de 9 est :",j)
    print("La fréquence d'apparition de 10 est :",k)
    print("\n")
