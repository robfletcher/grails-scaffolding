$(document).ready(function() {
	if (Modernizr.inputtypes.range) {
		$('select.range').grailsRangeInput();
	}

	if (Modernizr.history) {
		$('.scaffold-list').grailsList();
	}

	$('select.many-to-many').grailsAutocompleteInput();

	// prevent FOUC by only making body visible once document is ready
	$('body').addClass('ready');

	// focus first error field (this only works once page content is visible)
	$('.error:first').find('input, select, textarea').focus();
});

/**
 * Decorates many-to-many multiple selects with autocomplete controls.
 */
$.fn.grailsAutocompleteInput = function() {
	this.each(function() {
		var select = $(this);
		var listdata = [];
		select.find('option').each(function() {
			listdata.push({id: $(this).attr('value'), value: $(this).text()});
		});

		// create an autocomplete element to proxy the select
		var autocompleter = $('<input>', {
			id: select.attr('id') + '-autocompleter',
			type: 'search'
		}).autocomplete({
			source: listdata,
			select: function(event, ui) {
				var matchingOption = select.find('option[value=' + ui.item.id + ']');
				matchingOption.attr('selected', true);
				select.trigger('change');
			}
		});

		// create an output element that mirrors the content of the select when it changes
		var output = $('<output for="' + select.attr('id') + '"></output>');
		select.bind('change', function() {
			var selectedOptions = [];
			$(this).find('option:selected').each(function() {
				selectedOptions.push($(this).text());
			});
			$('output[for=' + this.id + ']').html(selectedOptions.join(', '));
		});

		// point the label for the select at the autocompleter instead
		$('label[for=' + select.attr('id') + ']').attr('for', autocompleter.attr('id'));

		select.after(output).after(autocompleter);
		select.trigger('change');
//		select.hide();
	});
};

/**
 * Replaces range selects with an HTML5 range control.
 */
$.fn.grailsRangeInput = function() {
	this.each(function() {
		var select = $(this);
		var min = select.find('option[value!=""]:first').attr('value');
		var max = select.find('option:last-child').attr('value');
		var value = select.val();
		var name = select.attr('name');
		var id = select.attr('id');

		// create a new range input with min & max based on the first & last options in the select
		var input = $('<input>', {
			type: 'range',
			name: name,
			id: id,
			min: min,
			max: max
		});
		input.bind('change', function() {
			$('output[for=' + this.id + ']').html($(this).val());
		});

		// create an output element to echo back the current range value (tabindex -1 is needed for Opera)
		var output = $('<output for="' + id + '"></output>').attr('tabindex', '-1');

		// if there's a current selection set the range value and the initial output text
		if (value) {
			input.val(value);
			output.html(value);
		} else {
			input.val(min);
			output.html(min);
		}

		// replace the select with the range input and insert the output before it
		select.replaceWith(input);
		input.before(output);
	});
};

/**
 * AJAX-enables pagination and sorting controls in a table.
 */
$.fn.grailsList = function() {
	var container = this;
	var links = this.find('.pagination a, th.sortable a');
	if (links) {
		// store current table state in history
		history.replaceState({html: container.html()}, '');

		// decorate list pagination & sorting controls with AJAX
		links.live('click', function() {
			var url = $(this).attr('href');
			container.load(url + ' .scaffold-list > *', function() {
				// put the new content into history and update the URL
				history.pushState({html: container.html()}, '', url);
			});
			return false;
		});

		// handle back button
		window.onpopstate = function(event) {
			// retrieve previous content from history if there is any
			if (event.state) {
				container.html(event.state.html);
			}
		};

		this.attr('role', 'liveregion');
	}
};
