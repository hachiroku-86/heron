from random import *

def generateur():
    tab2=[]
    for i in range (20):
        tab2.append(randint(1,100))
    a = tab2[0]
    for i in range (1,20):
        if tab2[i] < a :
            a = tab2[i]

    print("La liste est :")
    print (tab2)
    print ("Le plus petit nombre de la liste est ",a)
