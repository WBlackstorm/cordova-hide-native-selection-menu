
#import "HideSelection.h"

@implementation HideSelection

- (void)hideMenu:(CDVInvokedUrlCommand *)command {

  UIMenuController *theMenu = [UIMenuController sharedMenuController];

  [UIMenuController sharedMenuController].menuVisible = NO;

  //[[UIMenuController sharedMenuController] setTargetRect:CGRectMake(0, 0, 1, 1) inView:self.extraView];

  CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@""];

  [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
