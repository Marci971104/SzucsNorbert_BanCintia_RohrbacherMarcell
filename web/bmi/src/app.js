document.getElementById('bmi-form').addEventListener('submit', function(e){


  calculateBMI();
  
    e.preventDefault();
  }); 
  
  
  function calculateBMI(e) {
 
  var weight = document.getElementById('weight');
  var height = document.getElementById('height');
  var totalbmi = document.getElementById('total-bmi');
    
  totalbmi.value = Math.round( parseFloat(weight.value) / (Math.pow(parseFloat(height.value)/100,2)));
    
    
  }
  
  
  
  
  
  
  
  

