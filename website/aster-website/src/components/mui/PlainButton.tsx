import { Button } from "@mui/material";
import type { ButtonProps } from "@mui/material/Button";
import { styled } from "@mui/material/styles";

const StyledButton = styled(Button)(() => ({
    width: '200px',
    height: '40px',
    borderRadius: '200px',
    backgroundColor: 'white',
    boxShadow: 'none',
}));

export default function PlainButton(props: ButtonProps) {
    return (
        <StyledButton variant="contained" {...props} sx={{color: 'black', fontWeight: 600, textTransform: 'initial', fontSize: '16px', fontFamily: 'Segoe UI', px: '15px'}}>
        </StyledButton>
    );
}
