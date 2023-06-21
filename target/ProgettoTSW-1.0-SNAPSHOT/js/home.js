/*Slideshow*/
var slides = document.querySelectorAll('.slide');
var btns = document.querySelectorAll('.btn');
let currentSlide = 1;

// Navigazione Manuale
var manualNav = function(manual){
    slides.forEach((slide) => {
        slide.classList.remove('active');

        btns.forEach((btn) => {
            btn.classList.remove('active');
        });
    });

    slides[manual].classList.add('active');
    btns[manual].classList.add('active');
}

btns.forEach((btn, i) => {
    btn.addEventListener("click", () => {
        manualNav(i);
        currentSlide = i;
    });
});

// Navigazione Automatica
var repeat = function(activeClass){
    let active = document.getElementsByClassName('active');
    let i = 1;

    var repeater = () => {
        setTimeout(function(){
            [...active].forEach((activeSlide) => {
                activeSlide.classList.remove('active');
            });

            slides[i].classList.add('active');
            btns[i].classList.add('active');
            i++;

            if(slides.length === i){
                i = 0;
            }
            if(i >= slides.length){
                return;
            }
            repeater();
        }, 10000);
    }
    repeater();
}
repeat();
/*Fine slideshow*/

const observer = new IntersectionObserver(entries => {
    entries.forEach(entries => {
        const container = entries.target.querySelectorAll(".box");
        for (let i = 0; i < container.length; i++) {
            if (entries.isIntersecting)
            {
                for (let j = 0; j < container.length; j++) {
                    container.item(j).classList.add("box-animation");
                }
                return;
            }
            container.item(i).classList.remove("box-animation");
        }
    });
});

observer.observe(document.querySelector(".new-entry"));
observer.observe(document.querySelector(".best-seller"))
