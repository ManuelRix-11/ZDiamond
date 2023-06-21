const modal = document.querySelector(".form-section");

/* PopOut per login */
function openForm()
{
    modal.classList.add("open");
}
document.onclick = function(div)
{
    if(div.target.id !== "form" && div.target.id !== "icon" && div.target.id !== "username" && div.target.id !== "password")
        modal.classList.remove("open");
}
/* Fine PopOut per login */

/*Inizio Media Query Nav*/
const bottone = document.querySelector(".media-nav");
const nav = document.querySelector(".nav-list");

bottone.addEventListener("click", () => {nav.classList.toggle("media");})