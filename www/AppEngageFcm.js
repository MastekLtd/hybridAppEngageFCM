var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "AppEngageFcm", "coolMethod", [arg0]);
};
exports.send= function (success,error){
    exec(success, error, "AppEngageFcm", "send", []);
};

exports.event= function (arg0,success,error){
    exec(success, error, "AppEngageFcm", "event", arg0);
};
exports.startScreen= function (success,error){
    exec(success, error, "AppEngageFcm", "startScreen", []);
};
exports.endScreen= function (arg0,success,error){
    exec(success, error, "AppEngageFcm", "endScreen", [arg0]);
};
exports.crash= function (success,error){
    exec(success, error, "AppEngageFcm", "crash", []);
};
exports.end= function (success,error){
    exec(success, error, "AppEngageFcm", "end", []);
};

exports.my= function (success,error){
    exec(success, error, "AppEngageFcm", "my", []);
};