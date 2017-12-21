
#import "HideSelection.h"

@implementation HideSelection

- (void)pluginInitialize
{

    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(destroyMenu:) name:UIMenuControllerWillShowMenuNotification object:nil];

}

- (void)hideMenu:(CDVInvokedUrlCommand *)command {

    CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@""];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];

}

- (void)destroyMenu: (id)sender {

    UIMenuController *menu = [UIMenuController sharedMenuController];
    [menu setMenuVisible:NO];
    [menu performSelector:@selector(setMenuVisible:) withObject:[NSNumber numberWithBool:NO] afterDelay:0.];

}

@end
