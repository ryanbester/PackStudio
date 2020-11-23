function toggleMenu() {
    $('#mobile-nav-menu').stop().slideToggle(250);
    return false;
}

function toggleDocsNavigation() {
    $('#docs-navigation-list').stop().slideToggle(250);
    $('#docs-navigation-list-expander-glyph').toggleClass('expanded');
    return false;
}

function toggleDocsSidebar() {
    $('#docs-sidebar-list').stop().slideToggle(250);
    $('#docs-sidebar-list-expander-glyph').toggleClass('expanded');
    return false;
}

$(function() {
    const socialLinks = document.querySelectorAll('span.social-row-item-image[data-image]');
    for (let i = 0; i < socialLinks.length; i++) {
        let url = socialLinks[i].getAttribute('data-image');
        socialLinks[i].style.backgroundImage = 'url(' + url + ')';
    }

    const openMenu = (parentItem, subList) => {
        parentItem.toggleClass('expanded');
        subList.stop().slideToggle(125);
    };

    let counter = 0;

    const currentUrl = window.location.pathname.split("/");
    currentUrl.splice(0, 2);

    let lastMenu;

    $('ul ul.expandable-list').hide();
    $('li > ul.expandable-list').each(function(i) {
        let parentItem = $(this).parent('li');
        let subList = $(this).remove();

        parentItem.addClass('expandable-list-item');

        if (currentUrl[counter] === (parentItem.get(0).getAttribute('data-path'))) {
            openMenu(parentItem, subList);
            lastMenu = parentItem;
            counter++;
        }
        
        parentItem.wrapInner('<a/>').find('a').click(function() {
            openMenu(parentItem, subList);
        });
        parentItem.append(subList);
    });

    $(lastMenu).find('ul').children().each(function(i, ele) {
        if (currentUrl[counter] === ele.getAttribute('data-path')) {
            $(ele).find('a').addClass('active');
        }
    });

});