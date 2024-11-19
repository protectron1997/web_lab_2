const mySvg = document.getElementById("mySvg");

mySvg.addEventListener('click', function(event) {
    const rOption = document.querySelector('input[name="r"]:checked');
    if (!rOption) {
        console.log("Выберите значение R");
        return;
    }

    const oneRInPixels = 150;
    const plotSize = 400;
    const rValue = parseFloat(rOption.value); // Получаем значение R как число

    const tmpX = event.clientX - mySvg.getBoundingClientRect().left
    const tmpY = event.clientY - mySvg.getBoundingClientRect().top

    //теперь начало корд в левом нижнем углу
    x = tmpX
    y = -(tmpY - plotSize)

    //теперь - центр начало координат.
    x = x - (plotSize/2)
    y = y - (plotSize/2)

    //теперь выполнена нормализация относительно R
    x = x * (rValue / oneRInPixels);
    y = y * (rValue / oneRInPixels);

    //округляем
    x = x.toFixed(2);
    y = y.toFixed(2);

    //const x = (event.clientX - mySvg.getBoundingClientRect().left - oneRInPixels) * (rValue / oneRInPixels);
    //const y = (event.clientY - mySvg.getBoundingClientRect().top - oneRInPixels) * (rValue / oneRInPixels);

    console.log(`Кликнули на: tX=${tmpX}, tY=${tmpY}`);
    console.log(`Кликнули на: X=${x}, Y=${y}`);


    //добавляем значение в форму
    document.getElementById('x').value = x;
    document.getElementById('y').value = y;

    document.getElementById('coordinates-form').submit();
});
