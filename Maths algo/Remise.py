def remise():
    prixht=float(input("Saisissez le prix ht  ") )
    if prixht > 4000:
        prixht= prixht*0.92
    elif prixht >= 2500 :
        prixht=prixht*0.95
    prixTTC=prixht*1.196
    print("Le prix TTC est : " + prixttc)
   
   
