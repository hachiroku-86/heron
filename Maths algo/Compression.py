def compression(donnees):
    n = len(donnees)
    compression = [0 for j in range(n)]
    premier=donnees[0]
    j=0
    courant=premier
    for i in range (n):
        if (donnees[i]==courant):
            compression [j] = compression[j] + 1
        else:
                j = j + 1
                courant = donnees[i]
                compression[j] = 1
    return compression




    
