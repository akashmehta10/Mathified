function MainCtrl(dataFactory) {
  this.rowHeaders = true;
  this.colHeaders = true;
  this.db = {
		    items: dataFactory.generateArrayOfArrays(1000, 5)
		  };
  this.settings = {
		    contextMenu: [
		      'row_above', 'row_below', 'remove_row'
		    ]
		  };
}

MainCtrl.$inject = ['dataFactory'];

angular
  .module('app', ['ngHandsontable'])
  .controller('MainCtrl', MainCtrl);