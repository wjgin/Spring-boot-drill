/*!
* Start Bootstrap - Freelancer v7.0.5 (https://startbootstrap.com/theme/freelancer)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {
	
    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 72,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

document.querySelector('#submitButton').addEventListener('click', function(event){
	console.log('아우좀돼라sdf ');
//	var xhr = new XMLHttpRequest();
//	xhr.open('POST', '/test');
//	
//	xhr.onreadystatechange = function(){	// xhr 객체가 바뀌었을 (요청이 오갔을때 동작)
//		console.log('xhr.readyState = ' + xhr.readyState);
//		console.log('xhr.status = ' + xhr.status);
//		console.log('xhr.responseText = ' + xhr.responseText);
//		console.log(xhr)
//		if(xhr.readyState == 4 && xhr.status == 200) {	// 모든 통신이 끝남(4), 정상일 때(200)
//			document.querySelector('#target').innerHTML = xhr.responseText;	// 동작 
//		}
//	}
//	xhr.send();	//요청 보내기 
});