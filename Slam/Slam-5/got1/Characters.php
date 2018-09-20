<?php
 
abstract class Characters
{

	protected $id;
    protected $nom;
    protected $dateN;
    protected $dateM;
    protected $saCulture;
    static $count = 0;

	function __construct($id, $nom, $dateN, $dateM, $saCulture) {
		$this->id = $id;
		$this->nom = $nom;
		$this->dateN = $dateN;
		$this->dateM = $dateM; 
		$this->saCulture = $saCulture;
		self::$count++;
	}
 
    public function getNom()
    {
        return $this->nom;
    }

    public function setNom($nom)
    {
    	$this->nom = $nom;
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
    	$this->id = $id;
    }

    public function getDateN()
    {
        return $this->dateN;
    }

    public function setDateN($dateN)
    {
    	$this->dateN = $dateN;
    }

    public function getDateM()
    {
        return $this->dateM;
    }

    public function setDateM($dateM)
    {
    	$this->dateM = $dateM;
    }

    public function getSaCulture()
    {
        return $this->saCulture;
    }

    public function setSaCulture($saCulture)
    {
    	$this->saCulture = $saCulture;
    }

    public function __toString()
    {
    	return $this->id." ".$this->nom." ".$this->dateN." ".$this->dateM." ".$this->saCulture." ";
    }
} 

?>