const nav = document.getElementsByClassName('nav')[0];
console.log(nav);
window.addEventListener('scroll', () => {
    if(window.scrollY > 10){
        nav.classList.add("nav-scroll");
    } else {
        nav.classList.remove("nav-scroll");
    }
})