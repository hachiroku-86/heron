from random import*
def JeuCartes():
    jeux=[2,3,4,5,6,7,8,9,10,11,12,13,14,15]
    points=[2,3,4,5,6,7,8,9,10,1,2,3,4,11]
    paquetA=[0,0,0,0,0,0,0]
    paquetB=[0,0,0,0,0,0,0]
    L=len(jeux)
    j=randint(0,13)
    compteur=0
    compteur2=0
    while compteur<7:
        paquetA[compteur]=jeux[j]
        jeux[j]=0
        j=randint(0,13)
        while jeux[j]==0:
            j=randint(0,13)
        compteur=compteur+1
    print(paquetA)
    while compteur2<7:
        for i in range(len(jeux)):
            if jeux[i] != 0 :
                paquetB[compteur2]=jeux[i]
                compteur2=compteur2+1
    
    print(paquetB)
    scoremax=75
    scoreB=0
    for i in range(0,13):
        if jeux[i] != 0:
            scoreB=scoreB+points[i]
    scoreA=75-scoreB
    print(scoreA,scoreB)
