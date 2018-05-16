def moyenne():
    x1=float(input("note 1 "))
    n1=float(input("coef 1 "))
    x2=float (input("note 2 "))
    n2=float(input("coef 2 "))
    x3=float (input("note 3 "))
    n3=float(input("coef 3 "))
    moy=(x1*n1+x2*n2+x3*n3)/(n1+n2+n3)
    print("votre moyenne est ",moy)
    if moy >= 10 :
        print("vous etes admis!")
    else: 
        print("vous n'etes pas admis")
        
