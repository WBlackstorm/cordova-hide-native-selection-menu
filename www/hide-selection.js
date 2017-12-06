module.exports = {
    text_selection: function (successCallback, errorCallback) {      
        cordova.exec(successCallback, errorCallback, "HideSelection", "hideMenu", []);
    }
};
