def divisor(n):
    diviseurs=[]
    for i in range (1,n+1):
        if n%i==0:
            diviseurs.append(i)
    return diviseurs


def estPremier(n):
    if len (divisor(n))==2:
        return 1
    else:
        return -1


def plusPetitPremier(m):
    while estPremier(m) != 1:
        m=m+1
    return m

