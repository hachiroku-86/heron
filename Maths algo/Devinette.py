from random import *
def devinette():
    x=randint(1,100)
    n=0
    z=6
    while n !=x :
        if z!=0:
            z=z-1
            n=int(input("Entrer un nombre: "))
            if n<x:
                print("Nombre trop petit")
            if n>x:
                print("Nombre trop grand")
            if n==x:
                print("Bravo vous avez gagné !")
            if z==0:
                print("Perdu, dommage ;(")
