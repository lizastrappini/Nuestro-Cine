const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat');
const count = document.getElementById('count');
const total = document.getElementById('total');
const ticketPrice= document.getElementById("costo").value;


// update total and count
function updateSelectedCount() {
  const selectedSeats = document.querySelectorAll('.row .seat.selected');

  const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

  localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));
  document.getElementById('indexes').value = seatsIndex;
  //copy selected seats into arr
  // map through array
  //return new array of indexes

  const selectedSeatsCount = selectedSeats.length;

  count.innerText = selectedSeatsCount;
  total.innerText = selectedSeatsCount * ticketPrice;
  document.getElementById('preciototal').value = (selectedSeatsCount * ticketPrice);
 console.log(selectedSeats.length);
  if (selectedSeats.length == 0){
  console.log(selectedSeats.length);
  	document.getElementById('comprarentrada').disabled=true;
  	document.getElementById('comprarentrada').style.background = 'gray';
  } else {document.getElementById('comprarentrada').disabled=false;
  document.getElementById('comprarentrada').style.background = 'linear-gradient(#599bb3, #408c99)';}
  
 
}

// get data from localstorage and populate ui
function populateUI() {
  const selectedSeats = JSON.parse(localStorage.getItem('selectedSeats'));
  if (selectedSeats !== null && selectedSeats.length > 0) {
    seats.forEach((seat, index) => {
      if (selectedSeats.indexOf(index) > -1) {
        seat.classList.add('selected');
      }
    });
  }
  

}



// Seat click event
container.addEventListener('click', (e) => {
  if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
    e.target.classList.toggle('selected');
    updateSelectedCount();
  }
});

// intial count and total
updateSelectedCount();



