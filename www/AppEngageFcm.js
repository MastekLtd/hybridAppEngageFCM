var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "AppEngageAnalytics", "coolMethod", [arg0]);
};
exports.send= function (success,error){
    exec(success, error, "AppEngageAnalytics", "send", []);
};

exports.event= function (arg0,success,error){
    exec(success, error, "AppEngageAnalytics", "event", arg0);
};
exports.startScreen= function (success,error){
    exec(success, error, "AppEngageAnalytics", "startScreen", []);
};
exports.endScreen= function (arg0,success,error){
    exec(success, error, "AppEngageAnalytics", "endScreen", [arg0]);
};
exports.crash= function (success,error){
    exec(success, error, "AppEngageAnalytics", "crash", []);
};
exports.end= function (success,error){
    exec(success, error, "AppEngageAnalytics", "end", []);
};

exports.my= function (success,error){
    exec(success, error, "AppEngageAnalytics", "my", []);
};