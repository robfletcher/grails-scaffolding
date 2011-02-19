This is a sample project for prototyping changes to Grails scaffolding.

# To-Do

## Browser issues

 * Fonts look terrible in IE8 (oddly they look OK in IE6 & IE7)
 * Left padding on buttons is wrong on iPhone
 * Vertical position of autocomplete remove icon is inconsistent

## Data format

 * date / time format for show & list pages
 * Hide null/blank values in show view

## Forms

 * side-by-side display with stacking when viewport <= iPhone
 * put required class (and HTML5 attribute) on the input itself rather than the container
 * darker background with nice highlight effect for focused input (e.g. see tumblr sign up)
 * use data-constraint-range="0..5" etc. so we can enhance and validate inputs based on constraints
 * use size attribute where appropriate
 * required="required" on mandatory fields
 * autofocus - 1st field in error or 1st in form
 * Radio groups for enums (use select when more than x values?)
 * Dates using type="date" with 3-field JS enhanced version? Datepicker?

### Enhanced experience

 * Light-box show, edit, create direct from list page
 * Functional tests to ensure non-JS and JS versions work consistently
 * Autocomplete:
    * indicate that it's an autocompleter
    * clear on blur if no selection made
    * open autocomplete with focus? Mouse double-click?
    * suppress remove button on autocomplete for mandatory many-to-one
    * autocomplete for enums & inList constraint?
 * FOUC prevention by fade-in with CSS transition

## Navigation

 * Include nav using SiteMesh
 * All controllers in nav?
 * Primary & secondary nav for controllers / actions?
 * Highlight active state

## Mobile considerations

 * Test on iOS, Android, Blackberry, Kindle
 * Optimise inputs (e.g. not sure the autocomplete really works in iOS)

## Accessibility

## Integration

 * Depend on resources plugin & export appropriate resource declarations
 * Depend on jQuery & jQuery-UI (can we make the latter optional & disable autocomplete without it?)
 * Does modernizr need a plugin?
 * Should the scaffolding enhancements be a plugin so they can be removed if using non-jQuery framework?

## Misc

 * Test the use of many-to-many on create as it might not work
