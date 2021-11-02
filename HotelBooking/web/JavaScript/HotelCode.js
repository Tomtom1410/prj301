// Contact
function submitForm() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var address = document.getElementById('address').value;
    var feedback = document.getElementById('feedback').value;

    if (name !== '' && email !== '' && phone !== '' && address !== '' && feedback !== '') {
        alert("Thanks for your feedback!");
    }
}

//RoomDetail

function booking() {
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    var noOfRoom = document.getElementById("noOfRoom");
    var checkin = document.getElementById('checkin').value;
    var checkout = document.getElementById('checkout').value;
    if (noOfRoom.options[noOfRoom.selectedIndex].value === "0") {
        alert("Please choose number of rooms");
        document.getElementById('booking').onsubmit = function () {
            return false;
        };
    } else {
        if (name !== '' && email !== '' && phone !== '' && checkin !== '' && checkout !== '' && noOfRoom.options[noOfRoom.selectedIndex].value !== "0") {
            alert("Thank you for trusting and booking at our hotel!");
            document.getElementById('booking').submit();
        }
    }
}
