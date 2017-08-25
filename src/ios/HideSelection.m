
#import "HideSelection.h"

@implementation HideSelection

- (void)hideMenu:(CDVInvokedUrlCommand *)command
{

    UIMenuController *theMenu = [UIMenuController sharedMenuController];
    // CGRect selectionRect = CGRectMake (currentSelection.x, currentSelection.y, SIDE, SIDE);
    // [theMenu setTargetRect:selectionRect inView:self];
    [theMenu setMenuVisible:NO animated:YES];

    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK
                               messageAsString:msg];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
