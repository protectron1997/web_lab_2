//const mySvg = document.getElementById("mySvg");
const table = document.getElementById("table-status-table");


function drawPoints() {

    const existingPoints = mySvg.querySelectorAll('.point');
    existingPoints.forEach(point => point.remove());

    const rOption = document.querySelector('input[name="r"]:checked');
    if (!rOption) {
        console.log("Выберите значение R");
        return;
    }

    const oneRInPixels = 150;
    const rValue = parseFloat(rOption.value);


    const rows = table.querySelectorAll('tbody tr');
    rows.forEach(row => {
        const cells = row.querySelectorAll('td');
        if (cells.length >= 3) {
            const x = parseFloat(cells[0].textContent);
            const y = parseFloat(cells[1].textContent);



            const normalizedX = (x * oneRInPixels) / rValue + (mySvg.width.baseVal.value / 2);
            const normalizedY = -((y * oneRInPixels) / rValue) + (mySvg.height.baseVal.value / 2);


            const point = document.createElementNS("http://www.w3.org/2000/svg", "circle");
            point.setAttribute("cx", normalizedX);

            point.setAttribute("cy", normalizedY);
            point.setAttribute("r", 4);
            point.setAttribute("fill", "purple");
            point.setAttribute("class", "point");


            mySvg.appendChild(point);
        }
    });
}




const rOptions = document.querySelectorAll('input[name="r"]');
rOptions.forEach(option => {
    option.addEventListener('change', drawPoints);
});


drawPoints();
