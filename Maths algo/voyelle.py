def VoyelleCompte() :
    ch=(input("Saisir une phrase : "))
    voy=0
    v= ["a","e","i","o","u","y","A","E","I","O","U","Y"]
    for i in range (len(ch)):
        if (ch[i] in v):
            voy=voy+1
    print(voy)
    

