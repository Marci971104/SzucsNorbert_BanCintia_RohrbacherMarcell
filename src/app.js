document.getElementById('calorie-form').addEventListener('submit', function(e){


calculateCalories();

  e.preventDefault();
}); 


function calculateCalories(e) {
var age = document.getElementById('age');
var gender = document.querySelector('input[name="customRadioInline1"]:checked');
var weight = document.getElementById('weight');
var height = document.getElementById('height');
var activity = document.getElementById('activ').value;
var totalCalories = document.getElementById('total-calories');
 
  
  
  if (age.value === '' || weight.value === '' || height.value === '' || 150 < age.value || age.value < 0) {
   
  } else if(gender.id === 'male' && activity === "1") {
    totalCalories.value =Math.round( 1.2 * (66.5 + (13.75 * parseFloat(weight.value)) + (5.003 * parseFloat(height.value)) - (6.755 * parseFloat(age.value))));

  } else if(gender.id === 'male' && activity === "2") {
    totalCalories.value =Math.round( 1.375 * (66.5 + (13.75 * parseFloat(weight.value)) + (5.003 * parseFloat(height.value)) - (6.755 * parseFloat(age.value))));

  } else if (gender.id === 'male' && activity === "3") {
    totalCalories.value =Math.round( 1.55 * (66.5 + (13.75 * parseFloat(weight.value)) + (5.003 * parseFloat(height.value)) - (6.755 * parseFloat(age.value))));

  } else if(gender.id === 'male' && activity === "4") {
    totalCalories.value =Math.round( 1.725 * (66.5 + (13.75 * parseFloat(weight.value)) + (5.003 * parseFloat(height.value)) - (6.755 * parseFloat(age.value))));

  } else if(gender.id === 'male' && activity === "5") {
    totalCalories.value =Math.round( 1.9 * (66.5 + (13.75 * parseFloat(weight.value)) + (5.003 * parseFloat(height.value)) - (6.755 * parseFloat(age.value))));

  } else if(gender.id === 'female' && activity === "1") {
    totalCalories.value =Math.round( 1.2 * (655 + (9.563 * parseFloat(weight.value)) + (1.850 * parseFloat(height.value)) - (4.676 * parseFloat(age.value))));

  } else if(gender.id === 'female' && activity === "2") {
    totalCalories.value =Math.round( 1.375 * (655 + (9.563 * parseFloat(weight.value)) + (1.850 * parseFloat(height.value)) - (4.676 * parseFloat(age.value))));

  } else if(gender.id === 'female' && activity === "3") {
    totalCalories.value =Math.round( 1.55 * (655 + (9.563 * parseFloat(weight.value)) + (1.850 * parseFloat(height.value)) - (4.676 * parseFloat(age.value))));

  } else if(gender.id === 'female' && activity === "4") {

    totalCalories.value =Math.round( 1.725* (655 + (9.563 * parseFloat(weight.value)) + (1.850 * parseFloat(height.value)) - (4.676 * parseFloat(age.value))));

  }else if(gender.id ==='female' && activity ==="5"){
    totalCalories.value =Math.round( 1.9 * (655 + (9.563 * parseFloat(weight.value)) + (1.850 * parseFloat(height.value)) - (4.676 * parseFloat(age.value))));
  } 
  
}







