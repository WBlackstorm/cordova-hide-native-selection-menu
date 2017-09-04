
#import "HideSelection.h"

@implementation HideSelection

- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event {
    UITouch *theTouch = [touches anyObject];

    if ([theTouch tapCount] == 2  && [self becomeFirstResponder]) {

        // selection management code goes here...

        // bring up edit menu.
        UIMenuController *theMenu = [UIMenuController sharedMenuController];
        CGRect selectionRect = CGRectMake (currentSelection.x, currentSelection.y, SIDE, SIDE);
        [theMenu setTargetRect:selectionRect inView:self];
        [theMenu setMenuVisible:YES animated:YES];

    }
}

@end
