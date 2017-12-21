//
//  NSObject+CDVViewController_m.h
//  Medsoft Pro
//
//  Created by Weverton Peron on 21/12/17.
//

#import <Foundation/Foundation.h>
#import <Cordova/CDVViewController.h>

@interface CDVViewController (KongrosViewController)

- (NSArray *)webView:(UIWebView *)sender contextMenuItemsForElement:(NSDictionary *)element defaultMenuItems:(NSArray *)defaultMenuItems;

@end
