class Auto:
    def __init__(self,kleur,merk):
        self.kleur = kleur
        self.merk = merk
        
    #hierboven staat de constructor
        
    def verf(self, Nieuwe_kleur):
        self.kleur = Nieuwe_kleur
            #hierboven staat de method


Mijn_auto = Auto("zwart", "Porshe")
    #hierboven maak ik mijn product

print(Mijn_auto.kleur)
Mijn_auto.verf("Rood")
print(Mijn_auto.kleur)
    #hierboven gebruik ik de method

