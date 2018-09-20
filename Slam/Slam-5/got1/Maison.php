<?php
 
class Maison
{
    function __construct($myRegion, $nom, $devise, $dateFondation){
        $this->myRegion = $myRegion;
        $this->nom = $nom;
        $this->devise = $devise;
        $this->dateFondation = $dateFondation;
    }

    private $myRegion;
    private $nom;
    private $devise;
    private $dateFondation;
 
    public function getMyRegion()
    {
        return $this->myRegion;
    }

    public function setMyRegion($myRegion)
    {
    	$this->myRegion = $myRegion;
    }

    public function getNom()
    {
        return $this->nom;
    }

    public function setNom($nom)
    {
    	$this->nom = $nom;
    }

    public function getDevise()
    {
        return $this->devise;
    }

    public function setDevise($devise)
    {
    	$this->devise = $devise;
    }

    public function getDateFondation()
    {
        return $this->dateFondation;
    }

    public function setDateFondation($dateFondation)
    {
    	$this->dateFondation = $dateFondation;
    }

    public function __toString()
    {
    	return $this->myRegion." ".$this->nom." ".$this->devise." ".$this->dateFondation." ";
    }
} 

?>