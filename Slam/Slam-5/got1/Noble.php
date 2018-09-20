<?php
 
class Noble extends Characters
{

    function __construct($mere, $pere, $conjoint, $myHome, $id, $nom, $dateN, $dateM, $saCulture) {
    	parent::__construct($id, $nom, $dateN, $dateM, $saCulture);
        $this->mere = $mere;
        $this->pere = $pere;
        $this->conjoint = $conjoint;
        $this->myHome = $myHome;
    }

    private $mere;
    private $pere;
    private $conjoint;
    private $myHome;
 
    public function getMere()
    {
        return $this->mere;
    }

    public function setMere($mere)
    {
    	$this->mere = $mere;
    }

    public function getPere()
    {
        return $this->pere;
    }

    public function setPere($pere)
    {
    	$this->pere = $pere;
    }

    public function getConjoint()
    {
        return $this->conjoint;
    }

    public function setConjoint($conjoint)
    {
    	$this->conjoint = $conjoint;
    }

    public function getMyHome()
    {
        return $this->myHome;
    }

    public function setMyHome($myHome)
    {
        $this->myHome = $myHome;
    }

    public function __toString()
    {
    	echo parent::__toString();
    	return $this->mere." ".$this->pere." ".$this->conjoint." ".$this->myHome." ";
    }
} 

?>