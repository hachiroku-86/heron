<?php
 
class Hero extends Characters
{

    function __construct($nomActeur, $iamNoble, $id, $nom, $dateN, $dateM, $saCulture){
    	parent::__construct($id, $nom, $dateN, $dateM, $saCulture);
        $this->nomActeur = $nomActeur;
        $this->iamNoble = $iamNoble;
    }

    private $nomActeur;
    private $iamNoble;

    public function getNomActeur()
    {
        return $this->nomActeur;
    }

    public function setNomActeur($nomActeur)
    {
    	$this->nomActeur = $nomActeur;
    }

    public function getIamNoble()
    {
        return $this->iamNoble;
    }

    public function setIamNoble($iamNoble)
    {
        $this->iamNoble = $iamNoble;
    }

    public function __toString()
    {
    	return $this->nomActeur." ".$this->iamNoble." ";
    }
} 

?>