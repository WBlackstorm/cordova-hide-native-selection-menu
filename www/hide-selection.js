module.exports = {
    text_selection: function (successCallback, errorCallback) {
        alert(32);
        cordova.exec(successCallback, errorCallback, "HideSelection", "hideMenu", []);
    }
};
